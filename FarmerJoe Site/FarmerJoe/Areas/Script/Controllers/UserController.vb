Imports System.Web.Mvc

Namespace Areas.Script.Controllers
    Public Class UserController
        Inherits Controller

        Private _HashValue As String
        Public ReadOnly Property HashValue() As String
            Get
                Return Instance.Config.Settings.HashCode
            End Get
        End Property

        ' GET: Script/User
        Function Index() As ActionResult
            Return View()
        End Function

        ''' <summary>
        ''' Gibt Daten zum aktuell eingeloggten Nutzer zurück
        ''' </summary>
        ''' <param name="Hash">Zeichenkette welche bei Server und Client gleich sein muss</param>
        ''' <param name="ID">ID des Users</param>
        ''' <remarks></remarks>
        <HttpPost>
        Function UserData(ByVal Hash As String, Optional ByVal ID As Integer = 0) As JsonResult
            Return GetUserData(Hash, ID)
        End Function

        ''' <summary>
        ''' Gibt Daten zum aktuell eingeloggten Nutzer zurück
        ''' </summary>
        ''' <param name="Hash">Zeichenkette welche bei Server und Client gleich sein muss</param>
        ''' <param name="ID">ID des Users</param>
        ''' <param name="isGet">Pseudoparameter</param>
        ''' <remarks></remarks>
        <HttpGet>
        Function UserData(ByVal Hash As String, Optional ByVal ID As Integer = 0, Optional ByVal isGet As Integer = 0) As JsonResult
            If Instance.Config.Common.isDebug Then
                Return GetUserData(Hash, ID, isGet)
            Else
                Return Nothing
            End If
        End Function

        ''' <summary>
        ''' Gibt Daten zum aktuell eingeloggten Nutzer zurück
        ''' </summary>
        ''' <param name="Hash">Zeichenkette welche bei Server und Client gleich sein muss</param>
        ''' <param name="ID">ID des Users</param>
        ''' <param name="isGet">Pseudoparameter</param>
        ''' <remarks></remarks>
        Private Function GetUserData(ByVal Hash As String, Optional ByVal ID As Integer = 0, Optional ByVal isGet As Integer = 0) As JsonResult
            Dim actUser As Model.Frontend.User.UserModel = Nothing
            If Hash = HashValue Then
                If ID > 0 Then
                    actUser = Model.Cache.FeUser.GetByID(ID)
                    If actUser Is Nothing Then
                        Return Json(New With {.status = "Data invalid - can't find user."}, JsonRequestBehavior.AllowGet)
                    End If
                Else
                    Return Json(New With {.status = "No User selected."}, JsonRequestBehavior.AllowGet)
                End If
            Else
                Return Json(New With {.status = "HASH code is different from game, you criminal."}, JsonRequestBehavior.AllowGet)
            End If

            Return Json(actUser, JsonRequestBehavior.AllowGet)
        End Function

        ''' <summary>
        ''' Prüft ob der Nutzer mit der Email/Passwort Kombination existiert, gibt entsprechende Statusmeldungen zurück.
        ''' </summary>
        ''' <param name="EMailAddress">Anmeldename = E-Mail-Adresse des Users</param>
        ''' <param name="Password">Das Passwort des Users</param>
        ''' <remarks></remarks>
        <HttpPost>
        Function Login(ByVal Hash As String, ByVal EMailAddress As String, Password As String) As JsonResult
            Return GetLogin(Hash, EMailAddress, Password)
        End Function

        ''' <summary>
        ''' Prüft ob der Nutzer mit der Email/Passwort Kombination existiert, gibt entsprechende Statusmeldungen zurück.
        ''' </summary>
        ''' <param name="EMailAddress">Anmeldename = E-Mail-Adresse des Users</param>
        ''' <param name="Password">Das Passwort des Users</param>
        ''' <param name="isGet">Pseudoparameter</param>
        ''' <remarks></remarks>
        <HttpGet>
        Function Login(ByVal Hash As String, ByVal EMailAddress As String, Password As String, Optional ByVal isGet As Integer = 0) As JsonResult
            If Instance.Config.Common.isDebug Then
                Return GetLogin(Hash, EMailAddress, Password, isGet)
            Else
                Return Nothing
            End If
        End Function

        ''' <summary>
        ''' Prüft ob der Nutzer mit der Email/Passwort Kombination existiert, gibt entsprechende Statusmeldungen zurück.
        ''' </summary>
        ''' <param name="EMailAddress">Anmeldename = E-Mail-Adresse des Users</param>
        ''' <param name="Password">Das Passwort des Users</param>
        ''' <param name="isGet">Pseudoparameter</param>
        ''' <remarks></remarks>
        <HttpPost>
        Function GetLogin(ByVal Hash As String, ByVal EMailAddress As String, Password As String, Optional ByVal isGet As Integer = 0) As JsonResult
            Dim actUser As Model.Frontend.User.UserModel = Nothing
            If Hash = HashValue Then
                If Len(EMailAddress) > 0 AndAlso Len(Password) > 0 Then
                    actUser = Model.Cache.FeUser.GetByEmail(EMailAddress)
                    If Not actUser Is Nothing Then
                        If Helper.User.CheckPassword(actUser, Password, actUser.IsPasswordEncrypted) Then
                            Helper.User.EncryptPassword(actUser)
                            Return Json(actUser.Id, JsonRequestBehavior.AllowGet)
                        Else
                            Return Json(New With {.status = "Nick or password is wrong."}, JsonRequestBehavior.AllowGet)
                        End If
                    Else
                        Return Json(New With {.status = "Data invalid - cant find email."}, JsonRequestBehavior.AllowGet)
                    End If
                Else
                    Return Json(New With {.status = "Login or password cant be empty."}, JsonRequestBehavior.AllowGet)
                End If
            Else
                Return Json(New With {.status = "HASH code is different from game, you criminal."}, JsonRequestBehavior.AllowGet)
            End If

            Return Json(New With {.status = "error"}, JsonRequestBehavior.AllowGet)
        End Function

        ''' <summary>
        ''' Einen neuen Benutzer registrieren
        ''' </summary>
        ''' <param name="EMailAddress">Anmeldename = E-Mail-Adresse des Users</param>
        ''' <param name="Password">Das Passwort des Users</param>
        ''' <param name="Username">Der Nickname des Users</param>
        ''' <param name="RepeadPassword">Das Passwort des Users wiederholt</param>
        ''' <param name="Asset">Der Avatar des Users</param>
        ''' <remarks></remarks>
        <HttpPost>
        Function Reg(ByVal Hash As String, ByVal EMailAddress As String, Password As String, ByVal Username As String, ByVal RepeadPassword As String, ByVal Asset As String) As JsonResult
            If Hash = HashValue Then
                If Len(EMailAddress) > 0 AndAlso Len(Password) > 0 AndAlso Len(Username) > 0 Then
                    Dim actUser As Model.Frontend.User.UserModel = Nothing
                    actUser = Model.Cache.FeUser.GetByEmail(EMailAddress)
                    If actUser Is Nothing Then
                        If Password = RepeadPassword Then
                            Dim newUser As Model.Frontend.User.UserModel = Model.Frontend.User.UserModel.Objects.GetOrCreate(0)
                            newUser.Email = EMailAddress
                            newUser.Username = Username
                            newUser.Password = Helper.User.HashMD5(Password)
                            newUser.Energy = 100
                            newUser.MaxEnergy = 100
                            newUser.Asset = Asset
                            newUser.Save()
                            Return Json(newUser.Id, JsonRequestBehavior.AllowGet)
                        Else
                            Return Json(New With {.status = "Password and retype must be equal."}, JsonRequestBehavior.AllowGet)
                        End If
                    Else
                        Return Json(New With {.status = "E-Mail exists."}, JsonRequestBehavior.AllowGet)
                    End If
                Else
                    Return Json(New With {.status = "E-Mail, username and password cant be empty."}, JsonRequestBehavior.AllowGet)
                End If
            Else
                Return Json(New With {.status = "HASH code is different from game, you criminal."}, JsonRequestBehavior.AllowGet)
            End If

            Return Json(New With {.status = "error"}, JsonRequestBehavior.AllowGet)
        End Function

        ''' <summary>
        ''' Einen Avatar zu einem Nutzer speichern
        ''' </summary>
        ''' <remarks></remarks>
        <HttpPost>
        Function SaveAsset(ByVal Hash As String, ByVal Asset As String, Optional ByVal ID As Integer = 0) As JsonResult
            Dim actUser As Model.Frontend.User.UserModel = Nothing
            If Hash = HashValue Then
                If ID > 0 Then
                    actUser = Model.Cache.FeUser.GetByID(ID)
                    If actUser Is Nothing Then
                        Return Json(New With {.status = "Data invalid - can't find user."}, JsonRequestBehavior.AllowGet)
                    Else
                        actUser.Asset = Asset
                        actUser.Save()
                    End If
                Else
                    Return Json(New With {.status = "No User selected."}, JsonRequestBehavior.AllowGet)
                End If
            Else
                Return Json(New With {.status = "HASH code is different from game, you criminal."}, JsonRequestBehavior.AllowGet)
            End If

            Return Json(actUser.Asset, JsonRequestBehavior.AllowGet)
        End Function

        Function UploadAvatarImage(ID As Integer) As JsonResult
            Dim actUser As Model.Frontend.User.UserModel = Nothing
            actUser = Model.Cache.FeUser.GetByID(ID)
            If Not actUser Is Nothing Then
                actUser.AvatarImage = New Byte(Request.ContentLength) {}
                Request.InputStream.Read(actUser.AvatarImage, 0, Request.ContentLength)
                actUser.Save()
            End If

            Return Json(True, JsonRequestBehavior.AllowGet)
        End Function
    End Class
End Namespace
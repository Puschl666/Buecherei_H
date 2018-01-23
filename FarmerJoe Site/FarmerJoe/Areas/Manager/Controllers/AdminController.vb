Imports System.Web.Mvc

Namespace Areas.Manager.Controllers
    Public Class AdminController
        Inherits Controller

        ' GET: Manager/Admin
        Function Login() As ActionResult
            Return View()
        End Function

        ''' <summary>
        ''' Prüft ob der Benutzer existiert und meldet diesen in der Session an
        ''' </summary>
        ''' <param name="Username">Anmeldename</param>
        ''' <param name="Password"></param>
        ''' <remarks></remarks>
        <HttpPost>
        Function CheckLogin(ByVal Username As String, Password As String) As ActionResult
            Try
                Dim user As Model.Backend.User.UserModel = Model.Cache.BeUser.GetByEmail(Username)
                If Not user Is Nothing Then
                    If Helper.User.CheckPassword(user, Password, user.IsPasswordEncrypted) Then
                        Helper.User.EncryptPassword(user)
                        Session("Object").Login = user.Email
                        Session("Object").Secure = Guid.NewGuid.ToString()
                        Return Redirect("/manager")
                    Else
                        ViewData("ErrorMessage") = "Anmeldung nicht möglich, Nutzerdaten sind falsch."
                    End If
                Else
                    ViewData("ErrorMessage") = "Anmeldung nicht möglich, Nutzerdaten sind falsch."
                End If
            Catch ex As Exception
                ViewData("ErrorMessage") = "Anmeldung nicht möglich, bitte versuchen sie es später erneut."
            End Try

            Return View("~/Areas/Manager/Views/Admin/Login.vbhtml")
        End Function

        Function Logout() As ActionResult
            Session("Object").Login = ""
            Session("Object").Secure = ""

            Return Redirect("/manager/admin/login")
        End Function
    End Class
End Namespace
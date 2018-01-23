Imports System.Security.Cryptography

Namespace Helper
    Public Class User
        ''' <summary>
        ''' Prüft die Gültigkeit des Passworts. Dabei wird berücksichtigt, ob es verschlüsselt abgelegt wurde oder als Klartext in der Datenbank vorliegt.
        ''' </summary>
        ''' <param name="DatabaseUser">Benutzer, dessen Passwort geprüft werden soll.</param>
        ''' <param name="Password">Eingegebenes Passwort</param>
        ''' ''' <param name="isEncrypted">Gibt an, ob Passwort verschlüsselt vorliegt</param>
        ''' <remarks></remarks>
        Public Shared Function CheckPassword(DatabaseUser As Model.Frontend.User.UserModel, Password As String, isEncrypted As Boolean) As Boolean
            If Not isEncrypted Then
                If DatabaseUser.Password = Password Then
                    Return True
                End If
            End If
            If isEncrypted Then
                Dim PasswordHash = HashMD5(Password)
                If DatabaseUser.Password = PasswordHash Then
                    Return True
                Else
                    Dim PasswordNormalHash = NormalMD5(Password)
                    If DatabaseUser.Password = PasswordNormalHash Then
                        DatabaseUser.Password = Password
                        DatabaseUser.IsPasswordEncrypted = False
                        DatabaseUser.Save()
                        EncryptPassword(DatabaseUser)
                        Return True
                    End If
                End If
            End If
            Return False
        End Function
        Public Shared Function CheckPassword(DatabaseUser As Model.Backend.User.UserModel, Password As String, isEncrypted As Boolean) As Boolean
            If Not isEncrypted Then
                If DatabaseUser.Password = Password Then
                    Return True
                End If
            End If
            If isEncrypted Then
                Dim PasswordHash = HashMD5(Password)
                If DatabaseUser.Password = PasswordHash Then
                    Return True
                Else
                    Dim PasswordNormalHash = NormalMD5(Password)
                    If DatabaseUser.Password = PasswordNormalHash Then
                        DatabaseUser.Password = Password
                        DatabaseUser.IsPasswordEncrypted = False
                        DatabaseUser.Save()
                        EncryptPassword(DatabaseUser)
                        Return True
                    End If
                End If
            End If
            Return False
        End Function

        ''' <summary>
        ''' Verschlüsselt das Passwort eines Benutzers in der Datenbank, sofern es nicht bereits verschlüsselt ist.
        ''' </summary>
        ''' <param name="DatabaseUser">Benutzers, dessen Passwort verschlüsselt wird</param>
        ''' <remarks></remarks>
        Public Shared Sub EncryptPassword(DatabaseUser As Model.Frontend.User.UserModel)
            If Not DatabaseUser.IsPasswordEncrypted Then
                Dim PasswordHash = HashMD5(DatabaseUser.Password)
                DatabaseUser.Password = PasswordHash
                DatabaseUser.IsPasswordEncrypted = True
                DatabaseUser.Save()
            End If
        End Sub
        Public Shared Sub EncryptPassword(DatabaseUser As Model.Backend.User.UserModel)
            If Not DatabaseUser.IsPasswordEncrypted Then
                Dim PasswordHash = HashMD5(DatabaseUser.Password)
                DatabaseUser.Password = PasswordHash
                DatabaseUser.IsPasswordEncrypted = True
                DatabaseUser.Save()
            End If
        End Sub

        Public Shared Function HashMD5(OriginalString As String) As String
            Dim Ue As New UnicodeEncoding()
            Dim ByteSourceText() As Byte = Ue.GetBytes(OriginalString)
            Dim Md5 As New MD5CryptoServiceProvider()
            Dim ByteHash() As Byte = Md5.ComputeHash(ByteSourceText)
            Return Convert.ToBase64String(ByteHash)
        End Function

        Public Shared Function NormalMD5(OriginalString As String) As String
            Dim asciiBytes As Byte() = ASCIIEncoding.ASCII.GetBytes(OriginalString)
            Dim hashedBytes As Byte() = MD5CryptoServiceProvider.Create().ComputeHash(asciiBytes)
            Return BitConverter.ToString(hashedBytes).Replace("-", "").ToLower()
        End Function
    End Class
End Namespace
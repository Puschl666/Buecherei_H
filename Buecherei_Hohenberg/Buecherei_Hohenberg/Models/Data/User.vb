Imports System.Data.Entity

Public Class User
    Public Property user_id() As String
    Public Property vorname() As String
    Public Property nachname() As String
End Class

Public Class UserDBContext
    Inherits DbContext
    Public Property User() As DbSet(Of User)
End Class

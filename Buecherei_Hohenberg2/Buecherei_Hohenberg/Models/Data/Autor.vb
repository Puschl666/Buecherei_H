Imports System.Data.Entity

Public Class Autor
    Public Property autor_id() As Integer
    Public Property vorname() As String
    Public Property nachname() As String
End Class

Public Class AutorDBContext
    Inherits DbContext
    Public Property Autor() As DbSet(Of Autor)
End Class

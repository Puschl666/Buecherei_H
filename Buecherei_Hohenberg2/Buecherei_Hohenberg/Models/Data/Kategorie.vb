Imports System.Data.Entity

Public Class Kategorie
    Public Property kategorie_id As Integer
    Public Property bezeichnung As String
End Class

Public Class KategorieDBContext
    Inherits DbContext
    Public Property Kategorie() As DbSet(Of Kategorie)
End Class
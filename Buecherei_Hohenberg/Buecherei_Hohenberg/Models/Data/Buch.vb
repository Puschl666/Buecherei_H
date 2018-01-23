Imports System.Data.Entity

Public Class Buch
    Public Property buch_id() As Integer
    Public Property isbn() As String
    Public Property alte_buchnr() As String
    Public Property ausleihdatum As Date
    Public Property autor_id As Integer
    Public Property kategorie_id As Integer
    Public Property verlags_id As Integer
    Public Property kunden_id As Integer
End Class

Public Class BuchDBContext(Of)
    Inherits DbContext
    Public Property Buch() As DbSet(Of Buch)
End Class
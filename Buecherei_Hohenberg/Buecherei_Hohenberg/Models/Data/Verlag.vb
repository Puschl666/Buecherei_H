Imports System.Data.Entity

Public Class Verlag
    Public Property verlag_id As String
    Public Property bezeichnung As String
End Class

Public Class VerlagDBContext
    Inherits DbContext
    Public Property Verlag() As DbSet(Of Verlag)
End Class
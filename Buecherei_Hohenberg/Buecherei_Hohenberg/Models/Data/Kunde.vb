Imports System.Data.Entity

Public Class Kunde
    Public Property kunde_id As Integer
    Public Property vorname As String
    Public Property nachname As String
    Public Property ort As String
    Public Property plz As String
    Public Property adresse As String
End Class

Public Class KundeDBContext
    Inherits DbContext
    Public Property Kunde() As DbSet(Of Kunde)
End Class
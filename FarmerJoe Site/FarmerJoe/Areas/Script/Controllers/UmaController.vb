Imports System.Web.Mvc

Namespace Areas.Script.Controllers
    Public Class UmaController
        Inherits Controller

        Private _HashValue As String
        Public ReadOnly Property HashValue() As String
            Get
                Return Instance.Config.Settings.HashCode
            End Get
        End Property

        ' GET: Script/Uma
        Function Index() As ActionResult
            Return View()
        End Function

        ''' <summary>
        ''' Liefert Daten um das Charakter-Erstellen Menü zu füllen
        ''' </summary>
        ''' <remarks></remarks>
        <HttpPost>
        Function UMA(ByVal Hash As String) As JsonResult
            Return GetUMA(Hash)
        End Function

        ''' <summary>
        ''' Liefert Daten um das Charakter-Erstellen Menü zu füllen
        ''' </summary>
        ''' <param name="isGet">Pseudoparameter</param>
        ''' <remarks></remarks>
        <HttpGet>
        Function UMA(ByVal Hash As String, Optional ByVal isGet As Integer = 0) As JsonResult
            If Instance.Config.Common.isDebug Then
                Return GetUMA(Hash, isGet)
            Else
                Return Nothing
            End If
        End Function

        ''' <summary>
        ''' Liefert Daten um das Charakter-Erstellen Menü zu füllen
        ''' </summary>
        ''' <param name="isGet">Pseudoparameter</param>
        ''' <remarks></remarks>
        Function GetUMA(ByVal Hash As String, Optional ByVal isGet As Integer = 0) As JsonResult
            If Hash = HashValue Then
                Dim Accordion As List(Of Model.Backend.Helper.Accordion) = Model.Cache.Accordion.GetAll()

                Return Json(Accordion, JsonRequestBehavior.AllowGet)
            Else
                Return Json(New With {.status = "HASH code is different from game, you criminal."}, JsonRequestBehavior.AllowGet)
            End If

            Return Json(Nothing, JsonRequestBehavior.AllowGet)
        End Function

        ''' <summary>
        ''' Liefert Daten um Charakter erstellen zu können
        ''' </summary>
        ''' <remarks></remarks>
        <HttpPost>
        Function RandomSet(ByVal Hash As String, RaceID As String) As JsonResult
            Return GetRandomSet(Hash, RaceID)
        End Function

        ''' <summary>
        ''' Liefert Daten um Charakter erstellen zu können
        ''' </summary>
        ''' <param name="isGet">Pseudoparameter</param>
        ''' <remarks></remarks>
        <HttpGet>
        Function RandomSet(ByVal Hash As String, RaceID As String, Optional ByVal isGet As Integer = 0) As JsonResult
            If Instance.Config.Common.isDebug Then
                Return GetRandomSet(Hash, RaceID, isGet)
            Else
                Return Nothing
            End If
        End Function

        ''' <summary>
        ''' Liefert Daten um Charakter erstellen zu können
        ''' </summary>
        ''' <param name="isGet">Pseudoparameter</param>
        ''' <remarks></remarks>
        Function GetRandomSet(ByVal Hash As String, RaceID As String, Optional ByVal isGet As Integer = 0) As JsonResult
            If Hash = HashValue Then
                Dim RandomSet As Model.Backend.Helper.UMARandomSet = Model.Cache.RaceData.GetByRaceID(RaceID)

                Return Json(RandomSet, JsonRequestBehavior.AllowGet)
            Else
                Return Json(New With {.status = "HASH code is different from game, you criminal."}, JsonRequestBehavior.AllowGet)
            End If

            Return Json(Nothing, JsonRequestBehavior.AllowGet)
        End Function
    End Class
End Namespace
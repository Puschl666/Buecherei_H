Imports System.Web.Mvc

Namespace Areas.Manager.Controllers
    Public Class UmaController
        Inherits Controller

        ' GET: Manager/Uma
        Function Index() As ActionResult
            If Session("Object").Secure Is Nothing Then
                Return Redirect("/manager/admin/login")
            End If
            Return View()
        End Function

        Function Accordion() As ActionResult
            If Session("Object").Secure Is Nothing Then
                Return Redirect("/manager/admin/login")
            End If
            Dim Accordions As List(Of Model.Backend.Helper.Accordion) = Model.Cache.Accordion.GetAll()

            Return View("Accordion", Accordions)
        End Function

        Function NewAccordion() As ActionResult
            If Session("Object").Secure Is Nothing Then
                Return Redirect("/manager/admin/login")
            End If
            Return View("NewAccordion")
        End Function

        <HttpPost>
        Function NewAccordion(ByVal Hash As String, ByVal Name As String, ByVal Male As Boolean, ByVal Female As Boolean, ByVal SlotNr As Integer) As ActionResult
            If Session("Object").Secure Is Nothing Then
                Return Redirect("/manager/admin/login")
            End If
            Dim AccordionItem As Model.Backend.Uma.AccordionModel = Model.Backend.Uma.AccordionModel.Objects.GetOrCreate(0)

            If Not Accordion Is Nothing Then
                AccordionItem.Name = Name
                AccordionItem.Male = Male
                AccordionItem.Female = Female
                AccordionItem.SlotNr = SlotNr
                AccordionItem.Save()
            End If

            Return Accordion()
        End Function

        Function EditAccordion(ByVal Hash As String, Optional ByVal ID As Integer = 0) As ActionResult
            If Not Hash Is Nothing AndAlso Hash = Session("Object").Secure AndAlso ID > 0 Then
                Dim Accordion As Model.Backend.Uma.AccordionModel = Model.Cache.Accordion.GetByID(ID)
                If Not Accordion Is Nothing Then
                    Return View("EditAccordion", Accordion)
                Else
                    Return Redirect("/manager/admin/login")
                End If
            Else
                Return Redirect("/manager/admin/login")
            End If
        End Function

        <HttpPost>
        Function EditAccordion(ByVal Hash As String, ByVal ID As Integer, ByVal Name As String, ByVal Male As Boolean, ByVal Female As Boolean, ByVal SlotNr As Integer) As ActionResult
            If Session("Object").Secure Is Nothing Then
                Return Redirect("/manager/admin/login")
            End If
            Dim Accordion As Model.Backend.Uma.AccordionModel = Model.Cache.Accordion.GetByID(ID)

            If Not Accordion Is Nothing Then
                Accordion.Name = Name
                Accordion.Male = Male
                Accordion.Female = Female
                Accordion.SlotNr = SlotNr
                Accordion.Save()
            End If

            Return EditAccordion(Session("Object").Secure, ID)
        End Function

        Function RandomSet() As ActionResult
            If Session("Object").Secure Is Nothing Then
                Return Redirect("/manager/admin/login")
            End If
            Dim RandomSets As List(Of Model.Backend.Helper.UMARandomSet) = Model.Cache.RaceData.GetAll()

            Return View("RandomSet", RandomSets)
        End Function
    End Class
End Namespace
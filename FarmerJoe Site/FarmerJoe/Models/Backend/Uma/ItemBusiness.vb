Imports ProComp.Models
Imports ProComp.Models.Utils
Imports ProComp.Models.Visitors.SqlServer

Namespace Model.Backend.Uma
    Public Class ItemBusiness
        Inherits Base.Business

        Public Sub New()
            MyBase.New()

            ItemModel.Objects.Accept(New LoadVisitor(Mappings:=ItemModel.GetMappings, IgnoreDeleted:=True, ConnectionString:=Cache.Instance.ConnectionString))
        End Sub

        Public Overrides ReadOnly Property Count As Integer
            Get
                Return ItemModel.Objects.Count
            End Get
        End Property

        Public Overrides ReadOnly Property ModelType As Type
            Get
                Return GetType(ItemModel)
            End Get
        End Property

        Public ReadOnly Property LastResult() As Boolean
            Get
                Return ItemModel.Objects.LastResult
            End Get
        End Property

        Public Function GetByID(ID As Integer) As ItemModel
            Try
                Return ItemModel.Objects.GetByID(ID)
            Catch ex As Exception
                Return Nothing
            End Try
        End Function

        Public Function GetByUmaAccordionID(ByVal UmaAccordionID As Integer) As List(Of Helper.AccordionElement)
            Dim result As New List(Of Helper.AccordionElement)
            Dim accordionElement As Helper.AccordionElement = Nothing
            For Each item As ItemModel In ItemModel.Objects.FilterUnique("IdxUmaAccordionID", {UmaAccordionID})
                accordionElement = New Helper.AccordionElement()
                accordionElement.ID = item.Id
                accordionElement.Female = item.Female
                accordionElement.Male = item.Male
                accordionElement.Name = item.Name
                accordionElement.ParentID = item.ParentID
                accordionElement.SlotNr = item.SlotNr
                accordionElement.UmaAccordionID = item.UmaAccordionID
                accordionElement.HasButton = item.HasButton
                If item.ParentID > 0 Then
                    accordionElement.Subitem = GetByParentID(item.ParentID)
                Else
                    accordionElement.Subitem = Nothing
                End If
                result.Add(accordionElement)
            Next

            Return result
        End Function

        Public Function GetByParentID(ByVal ParentID As Integer) As Helper.AccordionElement
            Dim result As New Helper.AccordionElement()
            Dim Item As ItemModel = ItemModel.Objects.FilterUnique("IdxParentID", {ParentID})(0)
            result.ID = Item.Id
            result.Female = Item.Female
            result.Male = Item.Male
            result.Name = Item.Name
            result.ParentID = Item.ParentID
            result.SlotNr = Item.SlotNr
            result.Subitem = Nothing
            result.UmaAccordionID = Item.UmaAccordionID

            Return result
        End Function
    End Class
End Namespace

Imports ProComp.Models
Imports ProComp.Models.Utils
Imports ProComp.Models.Visitors.SqlServer

Namespace Model.Backend.Uma
    Public Class OverlayElementBusiness
        Inherits Base.Business

        Public Sub New()
            MyBase.New()

            OverlayElementModel.Objects.Accept(New LoadVisitor(Mappings:=OverlayElementModel.GetMappings, IgnoreDeleted:=True, ConnectionString:=Cache.Instance.ConnectionString))
        End Sub

        Public Overrides ReadOnly Property Count As Integer
            Get
                Return OverlayElementModel.Objects.Count
            End Get
        End Property

        Public Overrides ReadOnly Property ModelType As Type
            Get
                Return GetType(OverlayElementModel)
            End Get
        End Property

        Public ReadOnly Property LastResult() As Boolean
            Get
                Return OverlayElementModel.Objects.LastResult
            End Get
        End Property

        Public Function GetByID(ID As Integer) As OverlayElementModel
            Try
                Return OverlayElementModel.Objects.GetByID(ID)
            Catch ex As Exception
                Return Nothing
            End Try
        End Function

        Public Function GetByUmaSlotDataID(ByVal UmaSlotDatID As Integer) As Helper.UMARandomSet.OverlayElement()
            Dim OverlayElementList As IEnumerable(Of OverlayElementModel) = OverlayElementModel.Objects.FilterUniqueBegin("IdxSlotDataIDSortID", {UmaSlotDatID})
            Dim result(OverlayElementList.Count - 1) As Helper.UMARandomSet.OverlayElement
            Dim OverlayElements As Helper.UMARandomSet.OverlayElement = Nothing
            Dim Intex As Integer = 0
            For Each OverlayElement As OverlayElementModel In OverlayElementList
                OverlayElements = New Helper.UMARandomSet.OverlayElement()
                OverlayElements.possibleOverlays = Cache.OverlayData.GetByUmaOverlayElementID(OverlayElement.Id)
                result(Intex) = OverlayElements
                Intex += 1
            Next

            Return result
        End Function
    End Class
End Namespace
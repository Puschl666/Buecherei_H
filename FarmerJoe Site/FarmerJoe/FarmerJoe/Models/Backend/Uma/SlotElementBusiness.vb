Imports ProComp.Models
Imports ProComp.Models.Utils
Imports ProComp.Models.Visitors.SqlServer

Namespace Model.Backend.Uma
    Public Class SlotElementBusiness
        Inherits Base.Business

        Public Sub New()
            MyBase.New()

            SlotElementModel.Objects.Accept(New LoadVisitor(Mappings:=SlotElementModel.GetMappings, IgnoreDeleted:=True, ConnectionString:=Cache.Instance.ConnectionString))
        End Sub

        Public Overrides ReadOnly Property Count As Integer
            Get
                Return SlotElementModel.Objects.Count
            End Get
        End Property

        Public Overrides ReadOnly Property ModelType As Type
            Get
                Return GetType(SlotElementModel)
            End Get
        End Property

        Public ReadOnly Property LastResult() As Boolean
            Get
                Return SlotElementModel.Objects.LastResult
            End Get
        End Property

        Public Function GetByID(ID As Integer) As SlotElementModel
            Try
                Return SlotElementModel.Objects.GetByID(ID)
            Catch ex As Exception
                Return Nothing
            End Try
        End Function

        Public Function GetByUmaRaceDataID(ByVal UmaRaceDataID As Integer) As Helper.UMARandomSet.SlotElement()
            Dim SlotElements As IEnumerable(Of SlotElementModel) = SlotElementModel.Objects.FilterUniqueBegin("IdxUmaRaceDataIDSortID", {UmaRaceDataID})
            Dim result(SlotElements.Count - 1) As Helper.UMARandomSet.SlotElement
            Dim SlotElementItem As Helper.UMARandomSet.SlotElement = Nothing
            Dim Intex As Integer = 0
            For Each SlotElement As SlotElementModel In SlotElements
                SlotElementItem = New Helper.UMARandomSet.SlotElement()
                SlotElementItem.Info = SlotElement.Info
                SlotElementItem.requirement = SlotElement.Requirement
                SlotElementItem.condition = SlotElement.Condition
                SlotElementItem.possibleSlots = Cache.SlotData.GetByUmaSlotElementID(SlotElement.Id)
                result(Intex) = SlotElementItem
                Intex += 1
            Next

            Return result
        End Function
    End Class
End Namespace
Imports ProComp.Models
Imports ProComp.Models.Utils
Imports ProComp.Models.Visitors.SqlServer

Namespace Model.Backend.Uma
    Public Class SlotDataBusiness
        Inherits Base.Business

        Public Sub New()
            MyBase.New()

            SlotDataModel.Objects.Accept(New LoadVisitor(Mappings:=SlotDataModel.GetMappings, IgnoreDeleted:=True, ConnectionString:=Cache.Instance.ConnectionString))
        End Sub

        Public Overrides ReadOnly Property Count As Integer
            Get
                Return SlotDataModel.Objects.Count
            End Get
        End Property

        Public Overrides ReadOnly Property ModelType As Type
            Get
                Return GetType(SlotDataModel)
            End Get
        End Property

        Public ReadOnly Property LastResult() As Boolean
            Get
                Return SlotDataModel.Objects.LastResult
            End Get
        End Property

        Public Function GetByID(ID As Integer) As SlotDataModel
            Try
                Return SlotDataModel.Objects.GetByID(ID)
            Catch ex As Exception
                Return Nothing
            End Try
        End Function

        Public Function GetByUmaSlotElementID(ByVal UmaSlotElementID As Integer) As Helper.UMARandomSet.SlotData()
            Dim SlotDataList As IEnumerable(Of SlotDataModel) = SlotDataModel.Objects.FilterUniqueBegin("IdxSlotElementIDSortID", {UmaSlotElementID})
            Dim result(SlotDataList.Count - 1) As Helper.UMARandomSet.SlotData
            Dim SlotDatas As Helper.UMARandomSet.SlotData = Nothing
            Dim Intex As Integer = 0
            For Each SlotData As SlotDataModel In SlotDataList
                SlotDatas = New Helper.UMARandomSet.SlotData()
                SlotDatas.slotID = SlotData.SlotID
                SlotDatas.useSharedOverlayList = SlotData.UseSharedOverlayList
                SlotDatas.overlayListSource = SlotData.OverlayListSource
                SlotDatas.overlayElements = Cache.OverlayElement.GetByUmaSlotDataID(SlotData.Id)
                result(Intex) = SlotDatas
                Intex += 1
            Next

            Return result
        End Function
    End Class
End Namespace
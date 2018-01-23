Imports ProComp.Models
Imports ProComp.Models.Utils
Imports ProComp.Models.Visitors.SqlServer

Namespace Model.Backend.Uma
    Public Class RaceDataBusiness
        Inherits Base.Business

        Public Sub New()
            MyBase.New()

            RaceDataModel.Objects.Accept(New LoadVisitor(Mappings:=RaceDataModel.GetMappings, IgnoreDeleted:=True, ConnectionString:=Cache.Instance.ConnectionString))
        End Sub

        Public Overrides ReadOnly Property Count As Integer
            Get
                Return RaceDataModel.Objects.Count
            End Get
        End Property

        Public Overrides ReadOnly Property ModelType As Type
            Get
                Return GetType(RaceDataModel)
            End Get
        End Property

        Public ReadOnly Property LastResult() As Boolean
            Get
                Return RaceDataModel.Objects.LastResult
            End Get
        End Property

        Public Function GetByID(ID As Integer) As RaceDataModel
            Try
                Return RaceDataModel.Objects.GetByID(ID)
            Catch ex As Exception
                Return Nothing
            End Try
        End Function

        Public Function GetAll() As List(Of Helper.UMARandomSet)
            Dim result As New List(Of Helper.UMARandomSet)
            Dim RandomSet As Helper.UMARandomSet = Nothing
            For Each RaceData As RaceDataModel In RaceDataModel.Objects.GetAll()
                RandomSet = New Helper.UMARandomSet()
                RandomSet.data = New Helper.UMARandomSet.RaceData
                RandomSet.data.raceID = RaceData.RaceID
                RandomSet.data.slotElements = Cache.SlotElement.GetByUmaRaceDataID(RaceData.Id)
                result.Add(RandomSet)
            Next

            Return result
        End Function

        Public Function GetByRaceID(RaceID As String) As Helper.UMARandomSet
            Dim result As New Helper.UMARandomSet()
            Dim RaceData As RaceDataModel = RaceDataModel.Objects.FilterUnique("IdxRaceID", {RaceID})(0)
            result.data = New Helper.UMARandomSet.RaceData
            result.data.raceID = RaceData.RaceID
            result.data.slotElements = Cache.SlotElement.GetByUmaRaceDataID(RaceData.Id)

            Return result
        End Function
    End Class
End Namespace
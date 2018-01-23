Imports ProComp.Models
Imports ProComp.Models.Utils
Imports ProComp.Models.Visitors.SqlServer
Imports Newtonsoft.Json

Namespace Model.Backend.Uma
    Public Class OverlayDataBusiness
        Inherits Base.Business

        Public Sub New()
            MyBase.New()

            OverlayDataModel.Objects.Accept(New LoadVisitor(Mappings:=OverlayDataModel.GetMappings, IgnoreDeleted:=True, ConnectionString:=Cache.Instance.ConnectionString))
        End Sub

        Public Overrides ReadOnly Property Count As Integer
            Get
                Return OverlayDataModel.Objects.Count
            End Get
        End Property

        Public Overrides ReadOnly Property ModelType As Type
            Get
                Return GetType(OverlayDataModel)
            End Get
        End Property

        Public ReadOnly Property LastResult() As Boolean
            Get
                Return OverlayDataModel.Objects.LastResult
            End Get
        End Property

        Public Function GetByID(ID As Integer) As OverlayDataModel
            Try
                Return OverlayDataModel.Objects.GetByID(ID)
            Catch ex As Exception
                Return Nothing
            End Try
        End Function

        Public Function GetByUmaOverlayElementID(ByVal UmaOverlayElementID As Integer) As Helper.UMARandomSet.OverlayData()
            Dim OverlayDataList As IEnumerable(Of OverlayDataModel) = OverlayDataModel.Objects.FilterUniqueBegin("IdxOverlayElementIDSortID", {UmaOverlayElementID})
            Dim result(OverlayDataList.Count - 1) As Helper.UMARandomSet.OverlayData
            Dim OverlayDatas As Helper.UMARandomSet.OverlayData = Nothing
            Dim Intex As Integer = 0
            For Each OverlayData As OverlayDataModel In OverlayDataList
                OverlayDatas = New Helper.UMARandomSet.OverlayData()
                OverlayDatas.overlayID = OverlayData.OverlayID
                'OverlayDatas.maxRGB = JsonConvert.DeserializeObject(Of UnityEngine.Color)(OverlayData.MaxRGB)
                'OverlayDatas.minRGB = JsonConvert.DeserializeObject(Of UnityEngine.Color)(OverlayData.MinRGB)
                OverlayDatas.useSkinColor = OverlayData.UseSkinColor
                OverlayDatas.useHairColor = OverlayData.UseHairColor
                OverlayDatas.hairColorMultiplier = OverlayData.HairColorMultiplier
                OverlayDatas.colorChannelUse = OverlayData.ColorChannelUse
                OverlayDatas.colorChannel = OverlayData.ColorChannel
                OverlayDatas.overlayType = OverlayData.OverlayType
                OverlayDatas.AccordionID = OverlayData.AccordionID
                If OverlayData.RalatedTo > 0 Then
                    Dim odm As OverlayDataModel = Cache.OverlayData.GetByID(OverlayData.RalatedTo)
                    Dim od As New Helper.UMARandomSet.OverlayData
                    od.overlayID = odm.OverlayID
                    od.useHairColor = odm.UseHairColor
                    od.hairColorMultiplier = odm.HairColorMultiplier
                    od.colorChannelUse = odm.ColorChannelUse
                    od.colorChannel = odm.ColorChannel
                    od.overlayType = odm.OverlayType
                    od.AccordionID = odm.AccordionID
                    OverlayDatas.Relation = od
                End If
                result(Intex) = OverlayDatas
                Intex += 1
            Next

            Return result
        End Function
    End Class
End Namespace
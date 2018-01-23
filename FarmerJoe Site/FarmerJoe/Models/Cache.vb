Imports ProComp.Models.Visitors.SqlServer

Namespace Model
    Public Class Cache
        Private Sub New()
            ' Singleton
        End Sub

        Private Shared _instance As Cache = New Cache()
        Public Shared ReadOnly Property Instance() As Cache
            Get
                Return _instance
            End Get
        End Property

        Public Shared FeUser As Frontend.User.UserBusiness
        Public Shared BeUser As Backend.User.UserBusiness
        Public Shared Accordion As Backend.Uma.AccordionBusiness
        Public Shared RaceData As Backend.Uma.RaceDataBusiness
        Public Shared SlotElement As Backend.Uma.SlotElementBusiness
        Public Shared SlotData As Backend.Uma.SlotDataBusiness
        Public Shared OverlayElement As Backend.Uma.OverlayElementBusiness
        Public Shared OverlayData As Backend.Uma.OverlayDataBusiness

        Private InitializingStarted As Boolean = False
        Public Shared InitializingComplete As Boolean = False

        Private RefreshVisitorFeUser As RefreshVisitor
        Private RefreshVisitorBeUser As RefreshVisitor
        Private RefreshVisitorAccordion As RefreshVisitor
        Private RefreshVisitorAccordionItem As RefreshVisitor
        Private RefreshVisitorRaceData As RefreshVisitor
        Private RefreshVisitorSlotElement As RefreshVisitor
        Private RefreshVisitorSlotData As RefreshVisitor
        Private RefreshVisitorOverlayElement As RefreshVisitor
        Private RefreshVisitorOverlayData As RefreshVisitor

        Private Config As ConfigData.Data

        Public Sub Initialize(ConnectionString As String, RefreshPeriod As Integer, Config As ConfigData.Data)
            InitializingStarted = True
            Me.ConnectionString = ConnectionString
            Me.RefreshVisitorInterval = RefreshPeriod
            Me.Config = Config

            'User
            RefreshVisitorFeUser = New RefreshVisitor(Mappings:=Frontend.User.UserModel.GetMappings, ConnectionString:=Cache.Instance.ConnectionString)
            FeUser = New Frontend.User.UserBusiness
            Frontend.User.UserModel.Objects.Accept(RefreshVisitorFeUser, FeUser.GetRefreshPeriod)

            RefreshVisitorBeUser = New RefreshVisitor(Mappings:=Backend.User.UserModel.GetMappings, ConnectionString:=Cache.Instance.ConnectionString)
            BeUser = New Backend.User.UserBusiness
            Backend.User.UserModel.Objects.Accept(RefreshVisitorBeUser, BeUser.GetRefreshPeriod)

            'Accordion
            RefreshVisitorAccordion = New RefreshVisitor(Mappings:=Backend.Uma.AccordionModel.GetMappings, ConnectionString:=Cache.Instance.ConnectionString)
            Accordion = New Backend.Uma.AccordionBusiness
            Backend.Uma.AccordionModel.Objects.Accept(RefreshVisitorAccordion, Accordion.GetRefreshPeriod)

            'RandomSet
            RefreshVisitorRaceData = New RefreshVisitor(Mappings:=Backend.Uma.RaceDataModel.GetMappings, ConnectionString:=Cache.Instance.ConnectionString)
            RaceData = New Backend.Uma.RaceDataBusiness
            Backend.Uma.RaceDataModel.Objects.Accept(RefreshVisitorRaceData, RaceData.GetRefreshPeriod)

            RefreshVisitorSlotElement = New RefreshVisitor(Mappings:=Backend.Uma.SlotElementModel.GetMappings, ConnectionString:=Cache.Instance.ConnectionString)
            SlotElement = New Backend.Uma.SlotElementBusiness
            Backend.Uma.SlotElementModel.Objects.Accept(RefreshVisitorSlotElement, SlotElement.GetRefreshPeriod)

            RefreshVisitorSlotData = New RefreshVisitor(Mappings:=Backend.Uma.SlotDataModel.GetMappings, ConnectionString:=Cache.Instance.ConnectionString)
            SlotData = New Backend.Uma.SlotDataBusiness
            Backend.Uma.SlotDataModel.Objects.Accept(RefreshVisitorSlotData, SlotData.GetRefreshPeriod)

            RefreshVisitorOverlayElement = New RefreshVisitor(Mappings:=Backend.Uma.OverlayElementModel.GetMappings, ConnectionString:=Cache.Instance.ConnectionString)
            OverlayElement = New Backend.Uma.OverlayElementBusiness
            Backend.Uma.OverlayElementModel.Objects.Accept(RefreshVisitorOverlayElement, OverlayElement.GetRefreshPeriod)

            RefreshVisitorOverlayData = New RefreshVisitor(Mappings:=Backend.Uma.OverlayDataModel.GetMappings, ConnectionString:=Cache.Instance.ConnectionString)
            OverlayData = New Backend.Uma.OverlayDataBusiness
            Backend.Uma.OverlayDataModel.Objects.Accept(RefreshVisitorOverlayData, OverlayData.GetRefreshPeriod)

            InitializingComplete = True
        End Sub

        Public ReadOnly Property InitializeState As String
            Get
                Dim Result As String = ""

                If InitializingStarted Then
                    If InitializingComplete Then
                        Result = "<br /><br />Initializing completed.<br />" & vbCrLf
                    Else
                        Result = "<br /><br />Initializing...<br />" & vbCrLf
                    End If
                Else
                    Result = "<br /><br />Not Initialized.<br />" & vbCrLf
                End If
                Result &= "<ul>" & vbCrLf
                Result &= "<li>FeUser (Already Cached: " & GetCount(Instance.FeUser) & ")</li>" & vbCrLf
                Result &= "<li>BeUser (Already Cached: " & GetCount(Instance.BeUser) & ")</li>" & vbCrLf
                Result &= "<li>Accordion (Already Cached: " & GetCount(Instance.Accordion) & ")</li>" & vbCrLf
                Result &= "<li>RaceData (Already Cached: " & GetCount(Instance.RaceData) & ")</li>" & vbCrLf
                Result &= "<li>SlotElement (Already Cached: " & GetCount(Instance.SlotElement) & ")</li>" & vbCrLf
                Result &= "<li>SlotData (Already Cached: " & GetCount(Instance.SlotData) & ")</li>" & vbCrLf
                Result &= "<li>OverlayElement (Already Cached: " & GetCount(Instance.OverlayElement) & ")</li>" & vbCrLf
                Result &= "<li>OverlayData (Already Cached: " & GetCount(Instance.OverlayData) & ")</li>" & vbCrLf
                Result &= "</ul>"

                Return Result
            End Get
        End Property

        Private Function GetCount(ByRef Objekt As Object) As Integer
            If Not Objekt Is Nothing Then
                Return Objekt.count
            Else
                Return 0
            End If
        End Function

        Public ReadOnly Property GetBusiness(Name As String) As Base.Business
            Get
                Dim Value As Object = Nothing
                Dim FieldInfo = [GetType]().GetField(Name)
                If Not IsNothing(FieldInfo) Then
                    Return FieldInfo.GetValue(Me)
                Else
                    Return Nothing
                End If
            End Get
        End Property

        Public ConnectionString As String
        Public RefreshVisitorInterval As Integer

    End Class
End Namespace
Imports System.IO
Imports System.Xml
Imports System.Xml.Serialization
Imports System.Threading

Public Class Instance
    Public Shared ApplicationStart As DateTime = Now
    Public Shared ApplicationLoadState As String = "Not initialized!"
    Public Shared ApplicationStarted As Boolean = False

    Private Sub New()
        ' Singleton
    End Sub

    Private Shared _Config As New ConfigData.Data
    Public Shared Property Config As ConfigData.Data
        Get
            Return _Config
        End Get
        Set(value As ConfigData.Data)
            _Config = value
        End Set
    End Property

    Public Shared Sub ConnectAndLoadCache()
        Instance.ApplicationStarted = True
        Instance.ApplicationLoadState = "Start Initializing Thread..."

        Dim nthread As Thread
        nthread = New Thread(AddressOf Instance.DoConnectAndLoadCache)
        nthread.Start()
    End Sub

    Private Shared Sub DoConnectAndLoadCache()
        Model.Cache.Instance.Initialize(Instance.Config.ConnectionString, Instance.Config.Common.RefreshVisitorInterval, Instance.Config)
        Instance.ApplicationLoadState = "Cache complete (" & DateDiff(DateInterval.Second, Instance.ApplicationStart, Now) & " Seconds)!"
    End Sub

End Class

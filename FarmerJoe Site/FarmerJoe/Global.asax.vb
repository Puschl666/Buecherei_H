Imports System.Web.Mvc
Imports System.Web.Optimization
Imports System.Web.Routing

Public Class MvcApplication
    Inherits System.Web.HttpApplication

    Protected Sub Application_Start()
        AreaRegistration.RegisterAllAreas()
        RouteConfig.RegisterRoutes(RouteTable.Routes)
        BundleConfig.RegisterBundles(BundleTable.Bundles)

        FarmerJoe.App_Start.RegisterConfig(Server.MapPath("~"))
        Instance.ConnectAndLoadCache()
    End Sub

    Sub Session_Start(ByVal sender As Object, ByVal e As EventArgs)
        Session("Object") = New Session.Object
    End Sub

    Sub Session_End(ByVal sender As Object, ByVal e As EventArgs)
        Session("Object") = Nothing
    End Sub

    Private Sub Global_BeginRequest(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.BeginRequest
        If Not Model.Cache.InitializingComplete Then
            Response.StatusCode = 503
            Response.StatusDescription = "Service Unavailable"
            Response.Write("<html><head>")
            Response.Write("<title>Starting...</title>")
            Response.Write("<meta http-equiv=""refresh"" content=""1; URL=" & Request.Url.ToString & """>")
            Response.Write("</head><body style=""font-family:Arial,sans serif;"">")
            Response.Write("Application is starting ")

            If Instance.ApplicationStarted Then
                Response.Write("(" & DateDiff(DateInterval.Second, Instance.ApplicationStart, Now) & " seconds)...<br />")
            End If
            If Not Instance.ApplicationLoadState Is Nothing Then
                Response.Write("Current state: " & Instance.ApplicationLoadState)
            End If
            If Not Model.Cache.Instance Is Nothing Then
                Response.Write("<br />Cache state: " & Model.Cache.Instance.InitializeState & "")
            End If
            Response.Write("</body></html>")
            Response.End()
        End If
    End Sub

    Private Sub DB_OnQueryError(ByVal Sender As ProComp.Component.Database, ByVal e As Exception, ByVal Query As String)
        Dim Message As String = "DB Query failed.<br />" & e.Message & "<br />" & Replace(e.StackTrace, " bei", "<br />bei") & "<br />QUERY: " & Chr(13) & Chr(10) & Query & Chr(13) & Chr(10) & Chr(13) & Chr(10)
        Throw New Exception(Message)
    End Sub

    Private Sub DB_OnQueryExecuted(ByVal Sender As ProComp.Component.Database, ByVal Query As String)
        'Dim Message As String = "<br />" & Query
        'Dim Abort As Boolean = True
        'Global.My.Response.Write(Message)
    End Sub
End Class

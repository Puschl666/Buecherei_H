Imports System.Web.Mvc

Namespace Areas.Manager
    Public Class ManagerAreaRegistration
        Inherits AreaRegistration

        Public Overrides ReadOnly Property AreaName() As String
            Get
                Return "Manager"
            End Get
        End Property

        Public Overrides Sub RegisterArea(ByVal context As AreaRegistrationContext)
            context.MapRoute(
                "Manager_default",
                "Manager/{controller}/{action}/{hash}/{id}",
                New With {.area = "Manager", .controller = "Default", .action = "Index", .hash = UrlParameter.Optional, .id = UrlParameter.Optional},
                namespaces:=New String() {"FarmerJoe.Areas.Manager.Controllers"}
            )
        End Sub
    End Class
End Namespace
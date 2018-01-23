Imports System.Web.Mvc
Imports System.IO
Imports System.Drawing.Imaging

Public Class HomeController
    Inherits Controller


    ' GET: /Home
    Function Index() As ActionResult
        Return View("Index")
    End Function
End Class
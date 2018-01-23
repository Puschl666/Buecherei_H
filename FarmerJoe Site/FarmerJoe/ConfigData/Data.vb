Imports System.IO
Imports System.Xml
Imports System.Xml.Serialization

Namespace ConfigData
    <XmlRootAttribute(ElementName:="Configuration")>
    Public Class Data
        Public Common As Data.Structure.Common
        Public Connection As Data.Structure.Connection
        Public Settings As Data.Structure.Settings

        Public ReadOnly Property ConnectionString() As String
            Get
                Dim Result As String = ""
                Result = "Data Source=" & Connection.Host & ";Initial Catalog=" & Connection.Catalog & ";User ID=" & Connection.User & ";Password=" & Connection.Password
                Return Result
            End Get
        End Property

        Public Class [Structure]
            Public Structure Common
                Public RefreshVisitorInterval As Integer
                Public isDebug As Boolean
            End Structure

            Public Structure Connection
                Public Host As String
                Public Catalog As String
                Public User As String
                Public Password As String
            End Structure

            Public Structure Settings
                Public HashCode As String
            End Structure
        End Class
    End Class
End Namespace

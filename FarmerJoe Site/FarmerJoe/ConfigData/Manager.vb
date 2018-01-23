Imports System.IO
Imports System.Xml
Imports System.Xml.Serialization

Namespace ConfigData
    Public Class Manager
        Public Function LoadConfig(ByVal ConfigPath As String) As Object
            Dim Configinst As ConfigData.Data = New ConfigData.Data
            Dim ser As New XmlSerializer(Configinst.GetType)
            Dim fs As FileStream
            If (File.Exists(ConfigPath)) Then
                fs = New FileStream(ConfigPath, FileMode.Open, FileAccess.Read)
                Configinst = CType(ser.Deserialize(fs), ConfigData.Data)
                fs.Close()
            Else
                SaveConfig(ConfigPath, Configinst)
            End If
            Return Configinst
        End Function

        Public Function SaveConfig(ByVal ConfigPath As String, ByRef ConfigClass As ConfigData.Data) As Boolean
            Try
                Dim ser As New XmlSerializer(ConfigClass.GetType)
                Dim tw As TextWriter
                tw = New StreamWriter(ConfigPath, False)
                ser.Serialize(tw, ConfigClass)
                tw.Close()

                SaveConfig = True
            Catch
                SaveConfig = False
            End Try
        End Function
    End Class
End Namespace

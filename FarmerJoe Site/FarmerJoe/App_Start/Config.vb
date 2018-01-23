Imports System.IO
Imports System.Xml
Imports System.Xml.Serialization

Namespace FarmerJoe.App_Start
    Public Module Config
        Public Sub RegisterConfig(RootPath As String)
            If System.IO.File.Exists(RootPath & "Farmerjoe.config") Then
                Dim ser As New XmlSerializer(Instance.Config.GetType)
                Dim fs As FileStream

                fs = New FileStream(RootPath & "Farmerjoe.config", FileMode.Open, FileAccess.Read)
                Instance.Config = CType(ser.Deserialize(fs), ConfigData.Data)
                fs.Close()
            Else
                Debug.WriteLine("No Farmerjoe.config!")
                Throw New Exception("No Farmerjoe.config!")
            End If
        End Sub
    End Module
End Namespace

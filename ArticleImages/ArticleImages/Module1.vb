Imports System.IO
Imports System.Configuration
Module Module1
    Sub Main()
        Dim Path = ConfigurationSettings.AppSettings("Path")
        Dim DestinationPath = ConfigurationSettings.AppSettings("DestinationPath")
        Dim articleFiles = Directory.GetFiles(Path, "*.jpg", SearchOption.TopDirectoryOnly)
        For Each articleFile In articleFiles
            Dim tempDestinationPath As String = ""
            tempDestinationPath = DestinationPath + "\"
            Dim FileInfo As FileInfo = New FileInfo(articleFile)
            FileInfo.LastWriteTime = DateTime.Now
            Dim FileName As String = FileInfo.Name.Substring(0, 1)
            Select Case FileName
                Case 0
                    tempDestinationPath += "0XXXXXXX\"
                Case 1
                    tempDestinationPath += "1XXXXXXX\"
                Case 2
                    tempDestinationPath += "2XXXXXXX\"
                Case 3
                    tempDestinationPath += "3XXXXXXX\"
                Case 4
                    tempDestinationPath += "4XXXXXXX\"
                Case 5
                    tempDestinationPath += "5XXXXXXX\"
                Case 6
                    tempDestinationPath += "6XXXXXXX\"
                Case 7
                    tempDestinationPath += "7XXXXXXX\"
                Case 8
                    tempDestinationPath += "8XXXXXXX\"
                Case 9
                    tempDestinationPath += "9XXXXXXX\"
            End Select
            tempDestinationPath += FileInfo.Name
            File.Copy(FileInfo.FullName, tempDestinationPath, True)
        Next
    End Sub
End Module
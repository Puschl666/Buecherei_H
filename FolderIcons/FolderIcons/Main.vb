Imports System.IO
Imports System.Configuration

Module Main

    Sub Main()
        Dim Path = ConfigurationSettings.AppSettings("Path")
        Dim dirs As List(Of String) = New List(Of String)(Directory.EnumerateDirectories(Path))

        Dim mode = ConfigurationSettings.AppSettings("Mode")

        If mode = 1 Then

            For Each directoryName In dirs
                Console.WriteLine("{0}", directoryName.Substring(directoryName.LastIndexOf("\") + 1))
                Code.writeDesktopIni(directoryName)
                Code.copyFolderIcon(directoryName)
                File.SetAttributes(directoryName, FileAttributes.ReadOnly)
            Next
        Else
            For Each directoryName In dirs
                Code.deleteIcons(directoryName)
                File.SetAttributes(directoryName, FileAttributes.Normal)
            Next
        End If
        Console.ReadLine()
    End Sub

End Module

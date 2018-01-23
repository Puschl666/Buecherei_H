Imports System.Text
Imports System.IO
Imports System.Configuration
Public Class Code
    Shared Function createDesktopIni(FolderName As String)
        Dim DesktopIniString As StringBuilder = New StringBuilder

        DesktopIniString.AppendLine("[.ShellClassInfo]")
        DesktopIniString.AppendLine("ConfirmFileOp=0")
        DesktopIniString.AppendLine("IconFile=" & FolderName.Substring(FolderName.LastIndexOf("\") + 1) & ".ico")
        DesktopIniString.AppendLine("IconIndex=0")

        Return DesktopIniString
    End Function

    Shared Sub copyFolderIcon(FolderName As String)
        Dim ImagePath As String = ConfigurationSettings.AppSettings("ImagePath")

        ImagePath += FolderName.Substring(FolderName.LastIndexOf("\") + 1) & ".ico"
        If Not File.Exists(FolderName & "\" & FolderName.Substring(FolderName.LastIndexOf("\") + 1) & ".ico") Then

            If File.Exists(ImagePath) Then
                Console.WriteLine("Copy Folder Icon for {0}", FolderName.Substring(FolderName.LastIndexOf("\") + 1))
                File.Copy(ImagePath, FolderName & "\" & FolderName.Substring(FolderName.LastIndexOf("\") + 1) & ".ico")
                File.SetAttributes(FolderName & "\" & FolderName.Substring(FolderName.LastIndexOf("\") + 1) & ".ico", FileAttributes.Hidden)
            End If
        End If
    End Sub

    Shared Sub writeDesktopIni(FolderName As String)

        If Not File.Exists(FolderName & "\Desktop.ini") Then
            Dim DesktopIniString As StringBuilder = createDesktopIni(FolderName)        'Verzeichniss mitgeben
            Console.WriteLine("Create Desktop.ini for {0}", FolderName.Substring(FolderName.LastIndexOf("\") + 1))
            Dim fs As FileStream = File.Create(FolderName & "\Desktop.ini")
            Dim text As Byte() = New UnicodeEncoding().GetBytes(DesktopIniString.ToString)
            fs.Write(text, 0, text.Length)
            fs.Close()
            File.SetAttributes(FolderName & "\Desktop.ini", FileAttributes.Hidden)
        End If
    End Sub
    Shared Sub writeBatchDatei(FolderName As String)
        Dim fs As StreamWriter
        fs = File.AppendText("G:\Videos\folder.bat")

        Dim text As Byte() = New UnicodeEncoding().GetBytes("")
        'fs.WriteLine()
        fs.WriteLine("echo attrib +s " & FolderName)
        fs.Close()
    End Sub
    Shared Sub startCmd(FolderName As String)
        Dim p As New Process()

        '  p.StartInfo = New ProcessStartInfo("cmd.exe", String.Format("/c {0} & {1}", "echo attrib +s " & directoryName, "pause"))
        p.StartInfo.FileName = "cmd.exe"
        ' p.StartInfo.Arguments = String.Format("/c {0}", "echo attrib +s " & FolderName)
        p.StartInfo.Arguments = String.Format("/c {0}", "echo attrib +s G:\Videos")

        p.StartInfo.CreateNoWindow = True
        p.StartInfo.WindowStyle = ProcessWindowStyle.Hidden
        p.Start()
    End Sub

    Shared Sub deleteIcons(FolderName)
        If File.Exists(FolderName & "\Desktop.ini") Then
            File.Delete(FolderName & "\Desktop.ini")
        End If
        If File.Exists(FolderName & "\" & FolderName.Substring(FolderName.LastIndexOf("\") + 1) & ".ico") Then
            File.Delete(FolderName & "\" & FolderName.Substring(FolderName.LastIndexOf("\") + 1) & ".ico")
        End If
    End Sub

End Class

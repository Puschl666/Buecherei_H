Imports ProComp.Models
Imports ProComp.Models.Visitors.SqlServer
Imports ProComp.Models.Utils

Namespace Model.Backend.Uma
    Public Class AccordionModel
        Inherits Base.Model

        ''' <summary>
        ''' Die Metadaten für die Modelstruktur.
        ''' </summary>
        ''' <remarks></remarks>
        Public Class Meta
            Inherits Base.Meta

            ' Alle Datenbank-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Public Shared Name As Field = New StringField()
            Public Shared Male As Field = New BooleanField()
            Public Shared Female As Field = New BooleanField()
            Public Shared SlotNr As Field = New IntegerField()

            ' Indizes
            Public Shared IdxName As IdxField = New IdxField(FieldNames:={"Name"})

            ''' <summary>
            ''' Wir verwenden die SQL-Metas.
            ''' </summary>
            ''' <remarks></remarks>
            Public Class Sql
                ''' <summary>
                ''' Gibt an welche SQL-Tabelle die Daten für dieses Model enthält.
                ''' </summary>
                ''' <value></value>
                ''' <returns></returns>
                ''' <remarks></remarks>
                Public Shared Property Name = "be_uma_accordion"
            End Class
        End Class

        ' Properties für den Zugriff auf das Model. DB-Feler (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
        Public Property Name As String
        Public Property Male As Boolean
        Public Property Female As Boolean
        Public Property SlotNr As Integer

        Public Shared Function GetMappings() As Base.Mappings
            ' Mapping der DB-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Dim Mappings As Base.Mappings = New Base.Mappings
            Mappings.Add("Name", "Name")
            Mappings.Add("Male", "Male")
            Mappings.Add("Female", "Female")
            Mappings.Add("SlotNr", "SlotNr")
            Return Mappings
        End Function

        ''' <summary>
        '''Setzt den globalen Manager für die Verwaltung der Daten.
        ''' </summary>
        ''' <remarks></remarks>
        Public Shared Property Objects() As Base.Manager(Of AccordionModel) = New Base.Manager(Of AccordionModel)
    End Class
End Namespace

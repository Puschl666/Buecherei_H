Imports ProComp.Models
Imports ProComp.Models.Visitors.SqlServer
Imports ProComp.Models.Utils

Namespace Model.Backend.Uma
    Public Class SlotDataModel
        Inherits Base.Model

        ''' <summary>
        ''' Die Metadaten für die Modelstruktur.
        ''' </summary>
        ''' <remarks></remarks>
        Public Class Meta
            Inherits Base.Meta

            ' Alle Datenbank-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Public Shared SlotID As Field = New StringField()
            Public Shared UseSharedOverlayList As Field = New BooleanField()
            Public Shared OverlayListSource As Field = New IntegerField()
            Public Shared SlotElementID As Field = New IntegerField()

            Public Shared SortID As Field = New StringField()

            ' Indizes
            Public Shared IdxSlotElementIDSortID As IdxField = New IdxField(FieldNames:={"SlotElementID", "SortID"})

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
                Public Shared Property Name = "be_uma_slot_data"
            End Class
        End Class

        ' Properties für den Zugriff auf das Model. DB-Feler (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
        Public Property SlotID As String
        Public Property UseSharedOverlayList As Boolean
        Public Property OverlayListSource As Integer
        Public Property SlotElementID As Integer

        Public Shared Function GetMappings() As Base.Mappings
            ' Mapping der DB-Felder (ID, Deleted und ModifiedOn werden in den Basisklassen abgewickelt)
            Dim Mappings As Base.Mappings = New Base.Mappings
            Mappings.Add("SlotID", "SlotID")
            Mappings.Add("UseSharedOverlayList", "UseSharedOverlayList")
            Mappings.Add("OverlayListSource", "OverlayListSource")
            Mappings.Add("SlotElementID", "SlotElementID")
            Return Mappings
        End Function

        Public ReadOnly Property SortID As String
            Get
                Return Id.ToString().PadLeft(10, "0"c)
            End Get
        End Property

        ''' <summary>
        '''Setzt den globalen Manager für die Verwaltung der Daten.
        ''' </summary>
        ''' <remarks></remarks>
        Public Shared Property Objects() As Base.Manager(Of SlotDataModel) = New Base.Manager(Of SlotDataModel)
    End Class
End Namespace

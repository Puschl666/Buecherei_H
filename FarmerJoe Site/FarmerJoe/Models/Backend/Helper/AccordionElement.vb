Namespace Model.Backend.Helper
    Public Class AccordionElement
        Public ID As Integer
        Public UmaAccordionID As Integer
        Public Name As String
        Public Male As Boolean
        Public Female As Boolean
        Public SlotNr As Integer
        Public ParentID As Integer
        Public HasButton As Boolean
        Public Subitem As AccordionElement
        Public Button As Object = Nothing
    End Class
End Namespace
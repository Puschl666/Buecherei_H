Namespace Model.Base
    Public MustInherit Class Business
        Public ReadOnly Property GetRefreshPeriod As ProComp.Models.Contracts.Periodical
            Get
                Return New ProComp.Models.Contracts.Periodical With {.Interval = Cache.Instance.RefreshVisitorInterval, .Infinity = True}
            End Get
        End Property

        Public MustOverride ReadOnly Property Count As Integer
        Public MustOverride ReadOnly Property ModelType As Type
    End Class
End Namespace

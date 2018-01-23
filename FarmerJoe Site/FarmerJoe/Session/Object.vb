Namespace Session
    Public Class [Object]
        Private _Login As String
        Public Property Login() As String
            Get
                Return _Login
            End Get
            Set(ByVal value As String)
                _Login = value
            End Set
        End Property

        Private _Secure As String
        Public Property Secure() As String
            Get
                Return _Secure
            End Get
            Set(ByVal value As String)
                _Secure = value
            End Set
        End Property

    End Class
End Namespace
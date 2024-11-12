function App() {
    return (
    <div className="formContainer"> 
        <div className="formWrapper">
            <span className="logo">logo</span>
            <span className="title">Register</span>
            <form>
                <input type="text" placeholder=" name"/>
                <input type="email" placeholder="email"/>
                <input type="pasordsw" placeholder="password"/>
                <input type="file" />
                <button>Sign up</button>
            </form>
            <p> You do have an account? <span>Login</span></p>
        </div>
        
    </div>
    );
}

export default App;
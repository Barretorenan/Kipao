import React, { useState } from 'react';
import {Router, useNavigate} from 'react-router-dom';
import SignupScreen from "./SingupScreen";
import { Link } from 'react-router-dom';

const LoginScreen = () => {
    const history = useNavigate();
    const [email, setEmail] = useState('');
    const [senha, setsenha] = useState('');
    const [error, setError] = useState('');

    const handleLogin = async (event) => {
        event.preventDefault();

        try {
            const response = await fetch('/logar', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ email, senha })
            });

            if (response.ok) {
                // Login bem-sucedido, redirecionar para a tela Home
                //history('/home');
                history('/Home')
            } else {
                const data = await response.json();
                setError(data.message || 'Erro ao efetuar o login. Por favor, tente novamente.');
            }
        } catch (error) {
            setError('Erro ao efetuar o login. Por favor, tente novamente.');
        }
    };

    return (

        <div className="login-container">
            <h1>Login</h1>
            <form onSubmit={handleLogin}>
                <label htmlFor="email">Email:</label>
                <input
                    type="email"
                    id="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                /><br/><br/>

                <label htmlFor="senha">Senha:</label>
                <input
                    type="password"
                    id="senha"
                    value={senha}
                    onChange={(e) => setsenha(e.target.value)}
                    required
                /><br/><br/>

                <button type="submit">Login</button>
            </form>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <p>Não tem uma conta?
                <Link to="/SingupScreen">Cadastre-se</Link></p>
            <style>{`
                .login-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 100vh;
                background: linear-gradient(to bottom, #87CEEB, #ADD8E6);
                color: #fff;
            }

                form {
                display: flex;
                flex-direction: column;
                align-items: center;
            }

                label {
                margin-bottom: 8px;
            }

                input {
                margin-bottom: 16px;
            }

                button {
                margin-top: 16px;
            }

                p {
                margin-top: 16px;
                font-size: 14px;
            }
               `}
            </style>
        </div>

    );
};

export default LoginScreen;


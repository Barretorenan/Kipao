import React, { useState } from 'react';

const SignupScreen = () => {
    const [email, setEmail] = useState('');
    const [senha, setPassword] = useState('');
    const [error, setError] = useState('');
    const [successMessage, setSuccessMessage] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await fetch('/cadastro', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ email, senha })
            });

            if (response.ok) {
                setSuccessMessage('Usuário criado com sucesso!');
                setErrorMessage('');
            } else {
                const data = await response.json();
                setSuccessMessage('');
                setErrorMessage(data.message || 'Erro ao criar o usuário. Por favor, tente novamente.');
            }
        } catch (error) {
            setSuccessMessage('');
            setErrorMessage('Erro ao criar o usuário. Por favor, tente novamente.');
        }
    };

    return (
        <div className="signup-container">
            <h1>Criar Usuário</h1>
            <form onSubmit={handleSubmit}>
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
                    type="senha"
                    id="senha"
                    value={senha}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                /><br/><br/>

                <button type="submit">Criar Usuário</button>
            </form>
            {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
            {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}

            <style>
                {`
                .signup-container {
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
                `}
            </style>
        </div>
    );
};

export default SignupScreen;

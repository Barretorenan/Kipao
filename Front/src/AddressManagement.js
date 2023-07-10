import React, { useState } from 'react';

const AddressManagement = () => {
    const [logradouro, setLogradouro] = useState('');
    const [numero, setNumero] = useState('');
    const [bairro, setBairro] = useState('');
    const [cep, setCep] = useState('');
    const [successMessage, setSuccessMessage] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        const addressData = {
            logradouro,
            numero,
            bairro,
            cep
        };

        try {
            const response = await fetch('/criar-endereco/1', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(addressData)
            });

            if (response.ok) {
                setSuccessMessage('Endereço salvo com sucesso!');
                setErrorMessage('');
            } else {
                const data = await response.json();
                setSuccessMessage('');
                setErrorMessage(data.message || 'Erro ao salvar o endereço. Por favor, tente novamente.');
            }
        } catch (error) {
            setSuccessMessage('');
            setErrorMessage('Erro ao salvar o endereço. Por favor, tente novamente.');
        }
    };

    return (
        <div className="address-management-container">
            <h1>Gerenciar Endereço</h1>
            <form onSubmit={handleSubmit}>
                <label htmlFor="logradouro">Logradouro:</label>
                <input
                    type="text"
                    id="logradouro"
                    value={logradouro}
                    onChange={(e) => setLogradouro(e.target.value)}
                    required
                /><br/><br/>

                <label htmlFor="numero">Número:</label>
                <input
                    type="text"
                    id="numero"
                    value={numero}
                    onChange={(e) => setNumero(e.target.value)}
                    required
                /><br/><br/>

                <label htmlFor="bairro">Bairro:</label>
                <input
                    type="text"
                    id="bairro"
                    value={bairro}
                    onChange={(e) => setBairro(e.target.value)}
                    required
                /><br/><br/>

                <label htmlFor="cep">CEP:</label>
                <input
                    type="text"
                    id="cep"
                    value={cep}
                    onChange={(e) => setCep(e.target.value)}
                    required
                /><br/><br/>

                <button type="submit">Salvar Endereço</button>
            </form>

            {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
            {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}

            <style>
                {`
                .address-management-container {
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

export default AddressManagement;

import React, { useState } from 'react';

const CakeBuilder = () => {
    const coberturas = ['Chocolate', 'Morango', 'Creme', 'Marshmallow'];
    const recheios = ['Brigadeiro', 'Doce de Leite', 'Frutas', 'Creme'];
    const massas = ['Chocolate', 'Baunilha', 'Cenoura', 'Laranja'];

    const [selectedCobertura, setSelectedCobertura] = useState('');
    const [selectedRecheio, setSelectedRecheio] = useState('');
    const [selectedMassa, setSelectedMassa] = useState('');
    const [pedidoFeito, setPedidoFeito] = useState(false);
    const [pedidoSucesso, setPedidoSucesso] = useState(false);

    const fazerPedido = () => {
        // Verificar se todos os campos foram selecionados
        if (!selectedCobertura || !selectedRecheio || !selectedMassa) {
            return;
        }

        // Criar objeto do bolo
        const bolo = {
            cobertura: selectedCobertura,
            recheio: selectedRecheio,
            massa: selectedMassa
        };

        // Enviar o pedido para o backend
        fetch('/criar-bolo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(bolo)
        })
            .then(response => {
                if (response.ok) {
                    setPedidoFeito(true);
                    setPedidoSucesso(true);
                } else {
                    setPedidoFeito(true);
                    setPedidoSucesso(false);
                }
            })
            .catch(error => console.error(error));
    };

    return (
        <div className="cake-builder-container">
            <h1>Monte seu Bolo</h1>

            <h2>Tipos de Cobertura:</h2>
            <ul>
                {coberturas.map((cobertura) => (
                    <li key={cobertura}>
                        <button onClick={() => setSelectedCobertura(cobertura)}>
                            {cobertura}
                        </button>
                    </li>
                ))}
            </ul>
            <p>Cobertura selecionada: {selectedCobertura}</p>

            <h2>Tipos de Recheio:</h2>
            <ul>
                {recheios.map((recheio) => (
                    <li key={recheio}>
                        <button onClick={() => setSelectedRecheio(recheio)}>
                            {recheio}
                        </button>
                    </li>
                ))}
            </ul>
            <p>Recheio selecionado: {selectedRecheio}</p>

            <h2>Tipos de Massa:</h2>
            <ul>
                {massas.map((massa) => (
                    <li key={massa}>
                        <button onClick={() => setSelectedMassa(massa)}>
                            {massa}
                        </button>
                    </li>
                ))}
            </ul>
            <p>Massa selecionada: {selectedMassa}</p>

            <button onClick={fazerPedido} disabled={!selectedCobertura || !selectedRecheio || !selectedMassa}>
                Criar Bolo
            </button>

            {pedidoFeito && (
                <p className={`pedido-message ${pedidoSucesso ? 'success' : 'failure'}`}>
                    {pedidoSucesso ? 'Bolo criado com sucesso!' : 'Erro ao criar bolo   .'}
                </p>
            )}

            <style>
                {`
                .cake-builder-container {
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                    height: 100vh;
                    background: linear-gradient(to bottom, #87CEEB, #ADD8E6);
                    color: #fff;
                }

                ul {
                    list-style: none;
                    padding: 0;
                }

                button {
                    padding: 8px 16px;
                    background-color: #fff;
                    color: #000;
                    border: none;
                    border-radius: 5px;
                    cursor: pointer;
                    transition: background-color 0.3s;
                }

                button:hover {
                    background-color: #F0F0F0;
                }

                .pedido-message {
                    margin-top: 16px;
                    padding: 8px 16px;
                    border-radius: 5px;
                }

                .pedido-message.success {
                    background-color: #00FF00;
                }

                .pedido-message.failure {
                    background-color: #FF0000;
                }
                `}
            </style>
        </div>
    );
};

export default CakeBuilder;

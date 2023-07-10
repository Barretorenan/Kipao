import React, { useState } from 'react';

const CakeBuilder = () => {
    const coberturas = ['Chocolate', 'Morango', 'Creme', 'Marshmallow'];
    const recheios = ['Brigadeiro', 'Doce de Leite', 'Frutas', 'Creme'];
    const massas = ['Chocolate', 'Baunilha', 'Cenoura', 'Laranja'];

    const [selectedCobertura, setSelectedCobertura] = useState('');
    const [selectedRecheio, setSelectedRecheio] = useState('');
    const [selectedMassa, setSelectedMassa] = useState('');
    const [pedidoFeito, setPedidoFeito] = useState(false);

    const fazerPedido = () => {
        // Aqui você pode adicionar a lógica para enviar o pedido com os elementos selecionados
        // Por exemplo, enviar uma requisição POST para o backend com os dados do bolo
        setPedidoFeito(true);
    };

    return (
        <div>
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
                Fazer Pedido
            </button>

            {pedidoFeito && <p>Pedido realizado com sucesso!</p>}
        </div>
    );
};

export default CakeBuilder;

import React from 'react';

const CakeBuilder = () => {
    const coberturas = ['Chocolate', 'Morango', 'Creme', 'Marshmallow'];
    const recheios = ['Brigadeiro', 'Doce de Leite', 'Frutas', 'Creme'];
    const massas = ['Chocolate', 'Baunilha', 'Cenoura', 'Laranja'];

    return (
        <div>
            <h1>Monte seu Bolo</h1>
            <h2>Tipos de Cobertura:</h2>
            <ul>
                {coberturas.map((cobertura) => (
                    <li key={cobertura}>{cobertura}</li>
                ))}
            </ul>

            <h2>Tipos de Recheio:</h2>
            <ul>
                {recheios.map((recheio) => (
                    <li key={recheio}>{recheio}</li>
                ))}
            </ul>

            <h2>Tipos de Massa:</h2>
            <ul>
                {massas.map((massa) => (
                    <li key={massa}>{massa}</li>
                ))}
            </ul>
        </div>
    );
};

export default CakeBuilder;

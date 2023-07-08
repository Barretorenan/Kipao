import React from 'react';

const products = [
    { id: 1, name: 'Produto 1', description: 'Descrição do Produto 1', price: 10.99 },
    { id: 2, name: 'Produto 2', description: 'Descrição do Produto 2', price: 19.99 },
    { id: 3, name: 'Produto 3', description: 'Descrição do Produto 3', price: 5.99 },
];

const ProductList = () => {
    return (
        <div>
            <h1>Lista de Produtos</h1>
            {products.map((product) => (
                <div key={product.id}>
                    <h3>{product.name}</h3>
                    <p>{product.description}</p>
                    <p>Preço: R${product.price.toFixed(2)}</p>
                </div>
            ))}
        </div>
    );
};

export default ProductList;

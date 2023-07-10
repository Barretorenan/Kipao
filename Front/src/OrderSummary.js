import React from 'react';

const OrderSummary = () => {
    const products = [
        { id: 1, name: 'Produto 1', price: 10.99 },
        { id: 2, name: 'Produto 2', price: 19.99 },
        { id: 3, name: 'Produto 3', price: 5.99 },
    ];

    const calculateTotal = () => {
        let total = 0;
        products.forEach((product) => {
            total += product.price;
        });
        return total.toFixed(2);
    };

    const renderProductList = () => {
        return products.map((product) => (
            <li key={product.id}>
                {product.name} - R${product.price.toFixed(2)}
            </li>
        ));
    };

    return (
        <div>
            <h1>Finalização do Pedido</h1>
            <h2>Produtos:</h2>
            <ul>{renderProductList()}</ul>
            <p>Valor Total: R${calculateTotal()}</p>
            <p>Endereço de Entrega: Rua Exemplo, 123, Cidade, Estado</p>
        </div>
    );
};

export default OrderSummary;

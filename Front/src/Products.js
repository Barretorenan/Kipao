import React, { useEffect, useState } from 'react';

const Products = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetch('/listar-produtos')
            .then(response => response.json())
            .then(data => setProducts(data))
            .catch(error => console.error(error));
    }, []);

    return (
        <div>
            <h1>Produtos</h1>
            {products.length === 0 ? (
                <p>Carregando produtos...</p>
            ) : (
                <ul>
                    {products.map(product => (
                        <li key={product.id}>
                            <h2>{product.nome}</h2>
                            <p>{product.descricao}</p>
                            <p>{product.categoria}</p>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default Products;

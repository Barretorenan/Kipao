import React, { useEffect, useState } from 'react';

const Products = () => {
    const [products, setProducts] = useState([]);
    const [newProduct, setNewProduct] = useState({
        nome: '',
        descricao: '',
        categoria: ''
    });

    useEffect(() => {
        fetch('/listar-produtos')
            .then(response => response.json())
            .then(data => setProducts(data))
            .catch(error => console.error(error));
    }, []);

    const handleInputChange = (event) => {
        setNewProduct({
            ...newProduct,
            [event.target.name]: event.target.value
        });
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        fetch('/adicionar-produto', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newProduct)
        })
            .then(response => response.json())
            .then(data => {
                setProducts([...products, data]);
                setNewProduct({
                    nome: '',
                    descricao: '',
                    categoria: ''
                });
            })
            .catch(error => console.error(error));
    };

    const handleAddToCart = (product) => {
        // Implementar lógica para adicionar o produto ao carrinho
        console.log('Produto adicionado ao carrinho:', product);
    };

    return (
        <div className="products-container">
            <h1>Produtos</h1>
            <ul>
                {products.map(product => (
                    <li key={product.id}>
                        <h2>{product.nome}</h2>
                        <p>{product.descricao}</p>
                        <p>{product.categoria}</p>
                        <button onClick={() => handleAddToCart(product)}>Adicionar ao Carrinho</button>
                    </li>
                ))}
            </ul>

            <div className="create-product-section">
                <h2>Criar novo produto</h2>
                <form onSubmit={handleSubmit}>
                    <label htmlFor="nome">Nome:</label>
                    <input
                        type="text"
                        id="nome"
                        name="nome"
                        value={newProduct.nome}
                        onChange={handleInputChange}
                        required
                    /><br/><br/>

                    <label htmlFor="descricao">Descrição:</label>
                    <input
                        type="text"
                        id="descricao"
                        name="descricao"
                        value={newProduct.descricao}
                        onChange={handleInputChange}
                        required
                    /><br/><br/>

                    <label htmlFor="categoria">Categoria:</label>
                    <input
                        type="text"
                        id="categoria"
                        name="categoria"
                        value={newProduct.categoria}
                        onChange={handleInputChange}
                        required
                    /><br/><br/>

                    <button type="submit">Criar Produto</button>
                </form>
            </div>

            <style>
                {`
                .products-container {
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

                li {
                    margin-bottom: 16px;
                }

                .create-product-section {
                    background-color: blue;
                    padding: 16px;
                    margin-top: 32px;
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

export default Products;

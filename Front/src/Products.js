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

    return (
        <div>
            <h1>Produtos</h1>
            <ul>
                {products.map(product => (
                    <li key={product.id}>
                        <h2>{product.nome}</h2>
                        <p>{product.descricao}</p>
                        <p>{product.categoria}</p>
                    </li>
                ))}
            </ul>

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
    );
};

export default Products;

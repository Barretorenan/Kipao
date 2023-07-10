import React from 'react';
import { Link } from 'react-router-dom';
import ProductList from "./ProductList";
import Product from './Products';

const Home = () => {
    return (
        <div>
            <h1>Bem-vindo à nossa padaria!</h1>
            <p>O que você gostaria de fazer?</p>
            <ul>
                <li>
                    <Link to="/Products">Ver produtos</Link>
                </li>
                <li>
                    <Link to="/cake-builder">Montar bolo</Link>
                </li>
                <li>
                    <Link to="/order-history">Histórico de pedidos</Link>
                </li>
            </ul>
        </div>
    );
};

export default Home;

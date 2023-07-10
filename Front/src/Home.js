import React from 'react';
import { Link } from 'react-router-dom';
import OrderSummary from "./OrderSummary";

const Home = () => {
    return (
        <div className="home-container">
            <h1>Bem-vindo à padaria Kipão!</h1>
            <p>O que você gostaria de fazer?</p>
            <ul>
                <li>
                    <Link to="/Products">Ver produtos</Link>
                </li>
                <li>
                    <Link to="/CakeBuilder">Montar bolo</Link>
                </li>
                <li>
                    <Link to="/OrderHistory">Histórico de pedidos</Link>
                </li>
                <li>
                    <Link to="/SubscriptionPage">Fazer plano de assinatura</Link>
                </li>
                <li>
                    <Link to="/AddressManagement">Gerenciar endereço</Link>
                </li>
            </ul>

            <style>
                {`
                .home-container {
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

                a {
                    color: #fff;
                    text-decoration: none;
                }
                `}
            </style>
        </div>
    );
};

export default Home;

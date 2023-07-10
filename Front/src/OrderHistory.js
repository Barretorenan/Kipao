import React, { useState } from 'react';

const OrderHistory = () => {
    const [userId, setUserId] = useState('');
    const [orders, setOrders] = useState([]);
    const [assinaturas, setAssinaturas] = useState([]);
    const [error, setError] = useState('');

    const fetchOrders = async () => {
        try {
            const response = await fetch(`/recuperar-pedidos/1`);
            const data = await response.json();
            setOrders(data);
        } catch (error) {
            setError('Erro ao buscar histórico de pedidos.');
        }
    };

    const handleSearch = (event) => {
        event.preventDefault();
        fetchOrders();
    };

    const fetchSubscriptions = async () => {
        try {
            const response = await fetch(`/recuperar-assinaturas-usuario/1`);
            const data = await response.json();
            setAssinaturas(data);
        } catch (error) {
            setError('Erro ao buscar assinaturas.');
        }
    };

    const handleFetchSubscriptions = () => {
        fetchSubscriptions();
    };

    return (
        <div className="order-history-container">
            <h1>Histórico de Pedidos</h1>
            <form onSubmit={handleSearch}>
                <label htmlFor="userId">Número de Usuário:</label>
                <input
                    type="text"
                    id="userId"
                    value={userId}
                    onChange={(e) => setUserId(e.target.value)}
                    required
                /><br/><br/>

                <button type="submit">Buscar</button>
            </form>

            {error && <p style={{ color: 'red' }}>{error}</p>}

            {orders.length > 0 ? (
                <div>
                    <h3>Pedidos do Usuário {userId}:</h3>
                    <ul>
                        {orders.map((order) => (
                            <li key={order.id}>
                                <p>Número do Pedido: {order.id}</p>
                                <p>Data do Pedido: {order.data}</p>
                                <p>Status: {order.pedidoStatus}</p>
                                <p>Frete: {order.frete}</p>
                                <p>Valor: {order.valor}</p>
                            </li>
                        ))}
                    </ul>
                </div>
            ) : (
                <p>Nenhum pedido encontrado.</p>
            )}

            {assinaturas.length > 0 ? (
                <div>
                    <h3>Pedidos do Usuário {userId}:</h3>
                    <ul>
                        {assinaturas.map((order) => (
                            <li key={order.id}>
                                <p>Número da Assinatura: {order.id}</p>
                                <p>Data do Pedido: {order.horario}</p>
                                <p>Status: {order.status}</p>
                                <p>Quantidade de Itens: {order.tipo}</p>
                            </li>
                        ))}
                    </ul>
                </div>
            ) : (
                <p>Nenhum pedido encontrado.</p>
            )}

            <button onClick={handleFetchSubscriptions}>Recuperar Assinaturas</button>

            <style>
                {`
                .order-history-container {
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                    height: 100vh;
                    background: linear-gradient(to bottom, #87CEEB, #ADD8E6);
                    color: #fff;
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

export default OrderHistory;

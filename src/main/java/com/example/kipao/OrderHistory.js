import React, { useState } from 'react';

const OrderHistory = () => {
    const [userId, setUserId] = useState('');
    const [orders, setOrders] = useState([]);
    const [error, setError] = useState('');

    const fetchOrders = async () => {
        try {
            const response = await fetch(`/api/orders?userId=${userId}`);
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

    return (
        <div>
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
                                <p>Número do Pedido: {order.orderNumber}</p>
                                <p>Data do Pedido: {order.orderDate}</p>
                                <p>Status: {order.status}</p>
                            </li>
                        ))}
                    </ul>
                </div>
            ) : (
                <p>Nenhum pedido encontrado.</p>
            )}
        </div>
    );
};

export default OrderHistory;

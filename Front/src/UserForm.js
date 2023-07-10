import React, { useState } from 'react';

const UserForm = () => {
    const [name, setName] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState('');
    const [address, setAddress] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();

        // Lógica para criar o usuário com os dados fornecidos
        const user = {
            name,
            password,
            email,
            address
        };

        console.log(user);
    };

    return (
        <div>
            <h1>Criação de Usuário</h1>
            <form onSubmit={handleSubmit}>
                <label htmlFor="name">Nome:</label>
                <input
                    type="text"
                    id="name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                /><br/><br/>

                <label htmlFor="password">Senha:</label>
                <input
                    type="password"
                    id="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                /><br/><br/>

                <label htmlFor="email">Email:</label>
                <input
                    type="email"
                    id="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                /><br/><br/>

                <label htmlFor="address">Endereço:</label>
                <textarea
                    id="address"
                    value={address}
                    onChange={(e) => setAddress(e.target.value)}
                    required
                ></textarea><br/><br/>

                <button type="submit">Criar Usuário</button>
            </form>
        </div>
    );
};

export default UserForm;

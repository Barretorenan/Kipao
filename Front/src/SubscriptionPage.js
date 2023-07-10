import React, { useState } from 'react';

const SubscriptionPage = () => {
    const [selectedPlan, setSelectedPlan] = useState('');

    const handlePlanSelect = (plan) => {
        setSelectedPlan(plan);
    };

    const handleSubscribe = () => {
        // Lógica para enviar a solicitação de assinatura
        console.log('Assinatura realizada:', selectedPlan);
    };

    return (
        <div className="subscription-page">
            <h1>Escolha o seu Plano de Assinatura</h1>
            <div className="plan-list">
                <div className={`plan ${selectedPlan === 'Plano 3 Itens' ? 'selected' : ''}`}>
                    <h2>Plano 3 Itens</h2>
                    <p>R$19.99/mês</p>
                    <button onClick={() => handlePlanSelect('Plano 3 Itens')}>Selecionar</button>
                </div>
                <div className={`plan ${selectedPlan === 'Plano 5 Itens' ? 'selected' : ''}`}>
                    <h2>Plano 5 Itens</h2>
                    <p>R$29.99/mês</p>
                    <button onClick={() => handlePlanSelect('Plano 5 Itens')}>Selecionar</button>
                </div>
                <div className={`plan ${selectedPlan === 'Plano 7 Itens' ? 'selected' : ''}`}>
                    <h2>Plano 7 Itens</h2>
                    <p>R$49.99/mês</p>
                    <button onClick={() => handlePlanSelect('Plano 7 Itens')}>Selecionar</button>
                </div>
            </div>
            <button onClick={handleSubscribe}>Assinar</button>


            <style>
                {`
                .subscription-page {
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                    height: 100vh;
                    background: linear-gradient(to bottom, #87CEEB, #ADD8E6);
                    color: #fff;
                }

                .plan-list {
                    display: flex;
                    justify-content: center;
                    gap: 20px;
                }

                .plan {
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    padding: 20px;
                    background-color: #fff;
                    color: #000;
                    border-radius: 5px;
                    transition: background-color 0.3s;
                }

                .plan:hover {
                    background-color: #F0F0F0;
                }

                .plan.selected {
                    background-color: #ADD8E6;
                    color: #fff;
                }

                button {
                    padding: 10px 20px;
                    background-color: #000;
                    color: #fff;
                    border: none;
                    border-radius: 5px;
                    cursor: pointer;
                    transition: background-color 0.3s;
                }

                button:hover {
                    background-color: #333;
                }
                `}
            </style>
        </div>
    );
};

export default SubscriptionPage;

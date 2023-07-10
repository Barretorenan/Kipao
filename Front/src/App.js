import React from 'react';
import {BrowserRouter as Router, Switch, Route, Routes} from 'react-router-dom';
import LoginScreen from './LoginScreen';
import ProductList from './ProductList';
import OrderSummary from './OrderSummary';
import CakeBuilder from './CakeBuilder';
import UserForm from './UserForm';
import Home from './Home';
import Product from './Products';
import OrderHistory from './OrderHistory';
import SingupScreen from './SingupScreen';
import OrdersPage from "./OrderPage";
import SubscriptionPage from "./SubscriptionPage";
import AddressManagement from "./AddressManagement";

const App = () => {
    return (
        <div className="App">
            <Routes>
                <Route path="/Home" element={<Home/>} />
                <Route path="/" element={<LoginScreen/>} />
                <Route path="/Products" element={<Product/>} />
                <Route path="/SingupScreen" element={<SingupScreen/>} />
                <Route path="/OrderSummary" element={<OrderSummary/>} />
                <Route path="/CakeBuilder" element={<CakeBuilder/>} />
                <Route path="/OrderHistory" element={<OrderHistory/>} />
                <Route path="/OrderSummary" element={<OrderSummary/>} />
                <Route path="/SubscriptionPage" element={<SubscriptionPage/>} />
                <Route path="/AddressManagement" element={<AddressManagement/>} />
            </Routes>
        </div>  );
};

export default App;

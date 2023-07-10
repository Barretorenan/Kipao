import React from 'react';
import {BrowserRouter as Router, Switch, Route, Routes} from 'react-router-dom';
import LoginScreen from './LoginScreen';
import ProductList from './ProductList';
import OrderHistory from './OrderHistory';
import OrderSummary from './OrderSummary';
import CakeBuilder from './CakeBuilder';
import UserForm from './UserForm';
import Home from './Home';
import Product from './Products';

import SingupScreen from './SingupScreen';
const App = () => {
    return (
        <div className="App">
            <Routes>
                <Route path="/Home" element={<Home/>} />
                <Route path="/" element={<LoginScreen/>} />
                <Route path="/Products" element={<Product/>} />
                <Route path="/SingupScreen" element={<SingupScreen/>} />
                <Route path="/" element={<LoginScreen/>} />
            </Routes>
        </div>  );
};

export default App;

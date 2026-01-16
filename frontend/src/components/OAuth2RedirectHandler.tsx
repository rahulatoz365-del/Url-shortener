// frontend/src/components/OAuth2RedirectHandler.tsx
import React, { useEffect } from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';
import { useStoreContext } from '../contextApi/ContextApi';
import toast from 'react-hot-toast';
import Loader from './Loader';

const OAuth2RedirectHandler: React.FC = () => {
  const [searchParams] = useSearchParams();
  const navigate = useNavigate();
  const { setToken } = useStoreContext();

  useEffect(() => {
    const token = searchParams.get('token');
    const error = searchParams.get('error');

    if (token) {
      localStorage.setItem('JWT_TOKEN', token);
      setToken(token);
      toast.success('Login successful!');
      navigate('/dashboard');
    } else if (error) {
      toast.error(decodeURIComponent(error) || 'OAuth login failed');
      navigate('/login');
    } else {
      navigate('/login');
    }
  }, [searchParams, navigate, setToken]);

  return <Loader />;
};

export default OAuth2RedirectHandler;
// frontend/src/components/OAuthButtons.tsx
import React from 'react';
import { FaGoogle, FaGithub } from 'react-icons/fa';

const BACKEND_URL = import.meta.env.VITE_BACKEND_URL;

const OAuthButtons: React.FC = () => {
  const handleOAuthLogin = (provider: 'google' | 'github') => {
    window.location.href = `${BACKEND_URL}/oauth2/authorize/${provider}`;
  };

  return (
    <div className="flex flex-col gap-3 w-full mt-4">
      {/* Divider */}
      <div className="flex items-center my-2">
        <div className="flex-1 border-t border-gray-300"></div>
        <span className="px-4 text-gray-500 text-sm">OR</span>
        <div className="flex-1 border-t border-gray-300"></div>
      </div>

      {/* Google Button */}
      <button
        type="button"
        onClick={() => handleOAuthLogin('google')}
        className="flex items-center justify-center gap-3 w-full py-3 px-4 
                   bg-white border border-gray-300 rounded-lg 
                   hover:bg-gray-50 hover:shadow-md transition-all duration-200"
      >
        <FaGoogle className="text-red-500 text-xl" />
        <span className="text-gray-700 font-medium">Continue with Google</span>
      </button>

      {/* GitHub Button */}
      <button
        type="button"
        onClick={() => handleOAuthLogin('github')}
        className="flex items-center justify-center gap-3 w-full py-3 px-4 
                   bg-gray-900 rounded-lg 
                   hover:bg-gray-800 hover:shadow-md transition-all duration-200"
      >
        <FaGithub className="text-white text-xl" />
        <span className="text-white font-medium">Continue with GitHub</span>
      </button>
    </div>
  );
};

export default OAuthButtons;